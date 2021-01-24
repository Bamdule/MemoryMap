package com.bamdule.memorymap.model.VO;

import com.bamdule.memorymap.model.entity.User;

/**
 *
 * @author MW
 */
public class UserVO extends User {

    private String profileImgUrl;

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    @Override
    public String toString() {
        return "UserVO{" + "profileImgUrl=" + profileImgUrl + '}' + super.toString();
    }

}
