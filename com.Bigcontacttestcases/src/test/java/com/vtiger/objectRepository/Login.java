package com.vtiger.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login
{
@FindBy(name="user_name")
private WebElement username_tf;
@FindBy(name="user_password")
private WebElement password_tf;
@FindBy(id="submitButton")
private WebElement login_btn;

public WebElement getUserNameField()
{
	return username_tf;
}
public WebElement getPasswordField()
{
	return password_tf;
}
public WebElement getLoginButton()
{
	return login_btn;
}
}
