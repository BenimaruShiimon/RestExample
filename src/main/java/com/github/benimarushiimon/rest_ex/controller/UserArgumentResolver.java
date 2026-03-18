package com.github.benimarushiimon.rest_ex.controller;

import com.github.benimarushiimon.rest_ex.model.User;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(User.class);
    }

    @Override
    public @Nullable Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer, NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        Map<String, String[]> mapParams = webRequest.getParameterMap();
        if (!mapParams.containsKey("user") || mapParams.containsKey("user")) {
            throw new IllegalArgumentException("Один из параметров username/password отсутствует.");
        }
        return new User(mapParams.get("username")[0], mapParams.get("password")[0]);
    }
}
