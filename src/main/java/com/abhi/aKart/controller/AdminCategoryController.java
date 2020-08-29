package com.abhi.aKart.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abhi.aKart.Exception.categoryDataEmptyException;
import com.abhi.aKart.Exception.imageSizeException;
import com.abhi.aKart.entities.Category;
import com.abhi.aKart.service.CategorySer;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {

	Logger logger = LoggerFactory.getLogger(AdminCategoryController.class);
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CategorySer cotegorySer;

	@SuppressWarnings("unused")
	@PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> createCategory(@RequestParam String jsondata,
			@RequestParam(value = "file", required = false) MultipartFile multipart)
			throws IOException, categoryDataEmptyException, imageSizeException {

		if (multipart.getSize() < 100) {
			throw new imageSizeException("Size cant be greaterthan 100kb");
		} else if (jsondata.isEmpty()) {
			throw new categoryDataEmptyException("Fill the Category Data!");
		}
		Category category = objectMapper.readValue(jsondata, Category.class);
		if (multipart == null) {
			cotegorySer.saveCategory(category);
			return new ResponseEntity<String>("created!", HttpStatus.CREATED);
		}
		String filename = multipart.getOriginalFilename();
		Path path = Paths.get("src/main/resources/static/media/" + filename);
		if (filename.endsWith("jpg") || filename.endsWith("png")) {
			category.setPictureName(multipart.getOriginalFilename());
			category.setImage(multipart.getBytes());
			Files.write(path, multipart.getBytes());
			cotegorySer.saveCategory(category);
			return new ResponseEntity<String>("created!", HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("Image must be jpg or png!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/all-category")
	public ResponseEntity<Object> getCategory() {
		List<Category> allCategory = cotegorySer.getAllCategory();
		String path = "src/main/resources/static/media/";
		for (Category c : allCategory) {
			BufferedImage image = null;
			try {
				image = ImageIO.read(new File(path + c.getPictureName()));
			} catch (IOException e) {
				logger.error("problem with image ");
			}
			ByteArrayOutputStream bas = new ByteArrayOutputStream();
			// ---------if image not available for particular catogory
			if (c.getPictureName() != null) {
				char[] getType = c.getPictureName().toCharArray();
				int indexOf = c.getPictureName().indexOf('.');
				String type = "";
				for (int i = 0; i < getType.length; i++) {
					if (i > indexOf)
						type += getType[i];
				}
				// ----------type for formate
				try {
					ImageIO.write(image, type, bas);
				} catch (IOException e) {
					logger.error("problem with image ");
				}
				byte[] byteArray = bas.toByteArray();
				c.setImage(byteArray);
			}
		}
		return new ResponseEntity<Object>(allCategory, HttpStatus.OK);

	}

	@RequestMapping("/search")
	public List<Category> CategorySearch(@Param("keyword") String keyword) {
		List<Category> listProducts = cotegorySer.listAllCategory(keyword);
		return listProducts;

	}

}
