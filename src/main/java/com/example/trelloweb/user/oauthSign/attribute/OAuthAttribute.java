package com.example.trelloweb.user.oauthSign.attribute;

import com.example.trelloweb.user.signup.form.SignupForm;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttribute {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;

    @Builder
    public OAuthAttribute(Map<String,Object> attributes, String nameAttributeKey, String name, String email){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
    }
    public static OAuthAttribute of(String registrationId, String userNameAttributeName,
                                    Map<String,Object> attributes){
        return ofGoogle(userNameAttributeName, attributes);

    }

    private static OAuthAttribute ofGoogle(String userNameAttributeName, Map<String,Object> attributes){
        return OAuthAttribute.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
}
