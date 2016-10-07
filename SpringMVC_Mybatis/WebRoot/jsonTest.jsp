<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Json交互的测试</title>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	//请求Json，输出是Json
	function requestJson(){
		$.ajax({
			type:'post',
			url:'${ pageContext.request.contextPath }/requestJson.action',
			contentType:'application/json;charset=utf-8',
			// 数据格式是json串
			data:'{"name":"手机","price":6568}',
			success:function(data){//返回Json结果
				alert(data);
			}
		});
	}
	//请求key/value，输出是Json
	function responseJson(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/responseJson.action',
			//这里请求的是key/value，不需要指定contentType，因为默认情况下是key/value
			//contentType:'application/json;charset=utf-8',
			// 数据格式是json串
			data:'name=手机&price=6868',
			success:function(data){//返回Json结果
				alert(data.name);
			}
		});
	}
</script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求Json，输出是Json"/>
<input type="button" onclick="responseJson()" value="请求key/value，输出是Json"/>
</body>
</html>