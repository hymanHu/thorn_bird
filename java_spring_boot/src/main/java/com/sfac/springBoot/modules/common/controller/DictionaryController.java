package com.sfac.springBoot.modules.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfac.springBoot.modules.common.entity.ImageType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description DictionaryController
 * @Author HymanHu
 * @Date 2021/3/10 8:54
 */
@RestController
@RequestMapping("/api")
public class DictionaryController {

    @SuppressWarnings({ "rawtypes", "serial" })
	private static Map<String, Class> enumMap = new HashMap<String, Class>() {{
        put("imageType", ImageType.class);
    }};

    /**
     * 127.0.0.1/api/dictionary/imageType ---- get
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/dictionary/{name}")
    public List<Object> getEnum(@PathVariable String name) {
        try {
            if (enumMap.containsKey(name)) {
                Class clazz = enumMap.get(name);
                Method method = clazz.getDeclaredMethod("values");
                Object[] objects = (Object[]) method.invoke(null);
                return Arrays.asList(objects);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}