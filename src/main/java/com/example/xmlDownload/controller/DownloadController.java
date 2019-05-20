package com.example.xmlDownload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.xmlDownload.model.AuthAction;

@RestController
@RequestMapping("/download")
public class DownloadController {

	@Autowired
	DownloadService downloadService;

	@PostMapping
	public void downloadXml(@RequestParam String name, @RequestBody List<AuthAction> authorizationList) {
		downloadService.download(name,authorizationList);

	}

}
