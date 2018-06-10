package com.lishenming.web.controller;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 404找不到请求的网页
 * 400请求格式错误,比如传入的参数个数不对
 * 405发送的请求方式不对，例如get你发送了post请求
 * 500服务器内部异常
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * jsonPath("$.length()")
     * https://github.com/json-path/JsonPath 文档地址，git上搜索jsonpath
     * jsonpath的介绍
     */
    @Test
    public void whenQuerySuccess() throws Exception {
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/user")//发送get
                .param("username", "lishenming")
                .param("age", "25")
                .param("ageTo", "1993")
                .param("xxx", "66")
//                 .param("size","15")
//                 .param("page","3")//查询第三页的数据
//                 .param("sort","age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//构建发送头
                .andExpect(MockMvcResultMatchers.status().isOk())//期望状态码
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        //期望返回的数据是json。然后$表示返回的数据，

        System.out.println(contentAsString);
    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        String tom = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(("$.userName")).value("tom"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(tom);
    }

    //测试是否id只能接受数字
    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }


    /**
     * 56\",\"birthday\":"+time+"}"传入时间（数字）不要加引号，，
     *
     * @throws Exception
     */
       @Test
    public void whenCreateSuccess() throws Exception {
        Date date = new Date();
        long time = date.getTime();
        String content = "{\"userName\":\"lishenming\",\"passWord\":\"123456\",\"birthday\":" + time + "}";

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void whenUpdateSuccess() throws Exception {
           //LocalDateTime新的操作时间类
        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        long time = date.getTime();
        String content = "{\"id\":\"1\",\"userName\":\"lishenming\",\"passWord\":\"123456\",\"birthday\":" + time + "}";

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
           mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                   .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 文件的上传测试
     */
    @Test
    public void whenUploadSuccess() throws Exception {
        String file = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file")
                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello file".getBytes())))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("file::"+file);
    }


}
