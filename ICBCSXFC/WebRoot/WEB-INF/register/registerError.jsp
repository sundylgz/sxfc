<%@page pageEncoding="utf-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title>山西福彩工商银行缴费查询系统</title>
		<script type="text/javascript" language="javascript">
			var registerform;

			var sf_flag = 0;
			function sf(){
					if(sf_flag==1){
						$.alert({title:"提示!",type:'red',content:"请勿重复提交!"});
						return false;
					}else{
						sf_flag=1;
						return true;
					}
				}
				
			function paynext(){
        		
        		document.getElementById("myform").action = "login/toRegister.do";
		    	document.getElementById("myform").submit();
			}

			//设置提示信息
			function set_msg(id, msg) {
				$("#" + id).text(msg);
			}
        	
			function js_onLoad(){
			
				document.oncontextmenu = function(){return false;};
        		<%
        			String alertMsg = (String)request.getAttribute("alertMsg");
        		%>
			
				$.confirm({
					   title: '错误提示!',
					    content: '<%=alertMsg%>',
					    type:'red',
					    buttons: {
					        logoutUser: {
					            text: '确认',
					            action: function () {
					            	$('#myform').attr("action","login/toRegister.do").submit();
					            }
					        }
					    }
					});
			}
       </script>
	</head>
	<body onload="js_onLoad();">
	<form action="" method="post" id="myform" name="myform" class="form-signin" role="form" style="width: 95%"></form>
	</body>
</html>