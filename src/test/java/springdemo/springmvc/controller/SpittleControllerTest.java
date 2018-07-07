package springdemo.springmvc.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import springdemo.springmvc.domain.Spittle;
import springdemo.springmvc.repository.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {

        // 造一组数据 返回的model
        List<Spittle> expectedSpittles = createSpittleList(20);

        // mock一个接口的实现
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(400000, 20))
                .thenReturn(expectedSpittles);

        // mock spring mvc
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                //不用解析控制器的视图名
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void shouldShowRecentSpittles2() throws Exception {

        // 造一组数据 返回的model
        List<Spittle> expectedSpittles = createSpittleList(50);

        // mock一个接口的实现
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900, 50))
                .thenReturn(expectedSpittles);

        // mock spring mvc
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                //不用解析控制器的视图名
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void testSpittle() throws Exception {

        // 造一个数据
        Spittle expectedSpittle = new Spittle("hello", new Date());

        // mock一个接口的实现
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(1234L))
                .thenReturn(expectedSpittle);

        // mock spring mvc
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        mockMvc.perform(get("/spittles/1234"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));

    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("spittle" + i, new Date()));
        }
        return spittles;
}
}
