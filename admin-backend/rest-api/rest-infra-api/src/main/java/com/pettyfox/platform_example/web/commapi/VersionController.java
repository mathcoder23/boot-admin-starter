package com.pettyfox.platform_example.web.commapi;

import lombok.extern.slf4j.Slf4j;
import org.pettyfox.base.web.dto.rest.RestObjectResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 服务器软件版本信息
 *
 * @author Petty Fox
 */
@Controller
@RequestMapping("/api/commApi/version")
@Slf4j
public class VersionController {

    @Value("${project.version}")
    private String serviceVersion;
    @javax.annotation.Resource
    private ResourceLoader resourceLoader;

    @GetMapping("version.html")
    public void version(HttpServletResponse response) throws IOException {
        response(response, "classpath:/version/version.html", "text/html");
    }

    @GetMapping("element-index.css")
    public void element(HttpServletResponse response) throws IOException {
        response(response, "classpath:/version/element-index.css", "text/css");
    }

    @GetMapping("element-index.js")
    public void elementJs(HttpServletResponse response) throws IOException {
        response(response, "classpath:/version/element-index.js", "application/javascript");
    }

    @GetMapping("vue.js")
    public void vue(HttpServletResponse response) throws IOException {
        response(response, "classpath:/version/vue.js", "application/javascript");
    }

    @GetMapping("version.json")
    public void versionJson(HttpServletResponse response) throws IOException {
        response(response, "classpath:/version/version.json", "application/json");
    }

    @GetMapping("/")
    @ResponseBody
    public RestObjectResponse<String> version() {
        return RestObjectResponse.ok(serviceVersion);
    }

    private void response(HttpServletResponse response, String filename, String type) throws IOException {
        Resource resource = resourceLoader.getResource(filename);
        InputStream is = resource.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String data = "";
        StringBuffer sb = new StringBuffer();
        while ((data = br.readLine()) != null) {
            sb.append(data).append("\n");
        }
        br.close();
        isr.close();
        is.close();

        String html = sb.toString();
        response.setContentType(type + ";charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
    }
}
