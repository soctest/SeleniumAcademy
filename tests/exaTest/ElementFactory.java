package exaTest;

public class ElementFactory {

	public String iniciarSesion = "//a[contains(@href, 'login')]";

	public String facebookSignIn = "//span[text()='Login with Facebook']";

	public String netflixEmail = "//label[@class='input_id']/input";
//	public String netflixPass = "id_password";
	public String netflixPass = "//input[@id='id_password']";
	public String netflixRememberMe = "//div[@class='ui-binary-input login-remember-me']/label";
	public String netflixSignInBtn = "//button[@class='btn login-button btn-submit btn-small']";
	public String netFlixEmailErrMsglocator = "//div[@class='inputError']";
	public String netFlixPasswErrMsglocator = "//div[@class='ui-message-contents']";
	public String signUpNow = "//div[@class='login-signup-now']/a";
}
