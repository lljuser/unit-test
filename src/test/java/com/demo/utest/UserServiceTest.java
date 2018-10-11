package com.demo.utest;

import com.demo.utest.config.MyAutoConfig;
import com.demo.utest.service.MyService;
import com.demo.utest.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyAutoConfig.class})
@WebAppConfiguration
public class UserServiceTest {
    @Autowired
    private MyService myService;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getUser() throws Exception{
        //Assert.assertEquals("llj",myService.getName());
        mockMvc.perform(MockMvcRequestBuilders.post("/user/getuser")
                //.contentType(MediaType.APPLICATION_JSON)
                .param("id","110")
                .param("name","llj")
                .param("age","29")
                .param("address","anhui")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("llj"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void getName() throws Exception{
        //Assert.assertEquals("llj",myService.getName());
        mockMvc.perform(MockMvcRequestBuilders.get("/user/getname"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
}
