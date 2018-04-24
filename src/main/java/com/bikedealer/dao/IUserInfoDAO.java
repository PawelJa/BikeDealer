package com.bikedealer.dao;
import com.bikedealer.entity.UserInfo;

public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
}