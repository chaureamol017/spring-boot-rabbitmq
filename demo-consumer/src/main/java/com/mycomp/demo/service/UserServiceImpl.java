/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomp.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mycomp.demo.persistence.entity.User;
/**
 *
 * @author Amol
 */
@Service
public class UserServiceImpl implements UserService {
    private Map<Long, User> users = new HashMap<>();

    @Override
    public User saveUser(User user) {
        return users.put(user.getUserId(), user);
    }

    @Override
    public User updateUser(User user) {
        return users.put(user.getUserId(), user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public JSONObject getUserFormated(String id) {
        User user = getUser(id);
        try {
			return populateUserJson(user);
		} catch (JSONException e) {
		}
        return new JSONObject();
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }

    @Override
    public JSONObject populateUserJson(User user) throws JSONException {
        JSONObject detailsJson = new JSONObject();

        if (user != null) {
            populatUserJson(user, detailsJson);
            String registrationFor = user.getRegistrationFor();
            String middleName = user.getMiddleName();
            String emailId = user.getEmailId();

            detailsJson.put("registrationFor", registrationFor);
            detailsJson.put("middleName", middleName);
            detailsJson.put("emailId", emailId);
        }

        return detailsJson;
    }

    @Override
    public JSONObject populatUserJson(User user, JSONObject detailsJson) throws JSONException {
        if (detailsJson != null) {
            detailsJson = new JSONObject();
        }
        if (user != null) {
            Long userId = user.getUserId();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();

            detailsJson.put("userId", userId);
            detailsJson.put("firstName", firstName);
            detailsJson.put("lastName", lastName);
        }

        return detailsJson;
    }
}
