$(document).ready(function($) {

	var loginHtml = "<div class='login_content'>"+
						"<span class='form-title line-block'><font size='5' color='#466474'>团否.MOVIE - 登录</font></span>"+
						"<div  class='login-form'><form name='loginForm'  >"+
							"<span class='line-block'>用户名:<input type='text' name='userName'/></span>"+
							"<span class='line-block'>密&nbsp;&nbsp;码:<input type='password' name='password' /></span></form>"+
							"<span class='line-block'>"+
								"<span><font size='1' color='#DEAF9B'>如果还没有注册？点击<a href='#'>直接注册</a></font></span>"+
								"<span><button onclick='loginSubmit(this)' class='login-bt'>登录</button></span>"+
							"</span>"+
						"</div>"+
					"</div>";
	var regHtml = "<div class='regist-content'>"+
				"<span class='form-title line-block'><font size='5' color='#466474'>团否.MOVIE - 注册</font></span>"+
				"<div class='reg-info'>"+
					"<div class='img-area float-left'>"+
						"<span ><img width='120px' height='120px' src='./imgs/girl2.jpg'/></span>"+
						"<span class='line-block'><input type='file' value='上传'></input></span>"+
					"</div>"+
					"<div class='detail-info float-left'><form name='regForm' >"+
							"<span class='reg-line-block'>&nbsp;&nbsp;用户名<input name='userName' type='text'></input></span>"+
							"<span class='reg-line-block'>&nbsp;&nbsp;&nbsp;&nbsp;密码<input name='password' type='text'></input></"+"span>"+
							"<span class='reg-line-block'>密码确认<input name='confirm-password' type='text'></input></span>"+
							"<span class='reg-line-block'>&nbsp;&nbsp;&nbsp;&nbsp;性别<input name='sex' type='text'></input></span>"+
							"<span class='reg-line-block'>&nbsp;&nbsp;&nbsp;&nbsp;城市<input name='city' type='text'></input></span>"+
							"<span class='reg-line-block'>&nbsp;&nbsp;&nbsp;&nbsp;邮箱<input name='email' type='text'></input></span>"+
							"<span class='reg-line-block'>&nbsp;&nbsp;&nbsp;&nbsp;描述<input name='description' type='text'></input></span></form>"+
							"<span class='reg-line-block' id='registSubmit'><button class='reg-bt'  onclick='regSubmit(this);'>注册</"+"button></span>"+
					"</div>"+
				"</div>"+
			"</div>";
	 T$('login_link').onclick = function(){TINY.box.show(loginHtml,0,0,0,1)};
	 T$('reg_link').onclick = function(){TINY.box.show(regHtml,0,0,0,1);};
});