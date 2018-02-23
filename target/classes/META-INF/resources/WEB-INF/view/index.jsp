<%@ page language= "java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../static/js/vuejs/vue.js"></script>
<meta http-equiv="Content-Type" content="text/html; ccharset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="itany">
		{{msg}} <!-- 两对大括号{{}}称为模板，用来进行数据的绑定显示在页面中 -->
	</div>

	<h3>
		{{msg}}
	</h3>
</body>
<script>
		window.onload=function(){
			//配置是否允许vue-devtools检查代码，方便调试，生产环境中需要设置为false
			Vue.config.devtools=false;
			Vue.config.productionTip=false; //阻止vue启动时生成生产消息
			var vm=new Vue({
				el:'#itany', //指定关联的元素
				data:{ //存储数据
					msg:'Hello World'
				}
			});
		}
</script>
</html>