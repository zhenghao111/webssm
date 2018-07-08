package springdemo.springmvc.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import springdemo.springmvc.domain.Spitter;
import springdemo.springmvc.repository.SpitterRepository;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception{
        SpitterController controller = new SpitterController();

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
//        SpitterRepository mockRepo = mock(SpitterRepository.class);
//        Spitter unsaved = new Spitter("zheng", "hao", "zhenghao", "123456");
//        Spitter saved = new Spitter("zheng", "hao", "zhenghao", "123456");
//        when(mockRepo.save(unsaved)).thenReturn(saved);
//
//        SpitterController controller = new SpitterController(mockRepo);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//        mockMvc.perform(post("/spitter/register")
//        .param("firstName", "zheng")
//        .param("lastName", "hao")
//        .param("userName", "zhenghao")
//        .param("password", "123456"))
//                .andExpect(redirectedUrl("/spitter/zhenghao"));

//        verify(mockRepo, atLeastOnce()).save(unsaved);



    }
}
