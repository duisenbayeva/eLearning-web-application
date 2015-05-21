<%-- 
    Document   : localtest
    Created on : 20.04.2014, 19:12:41
    Author     : asusa
--%>

<%@page import="entities.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%
    ArrayList<String> test = (ArrayList<String>) request.getServletContext().getAttribute("test");
    int j=0;
    Student currentUser = (Student)request.getSession().getAttribute("currentUser");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>e-Learning</title>
        <meta name="keywords" content="learning" />
        <link href="default.css" rel="stylesheet" type="text/css" media="screen" />
        <script src="js/jquery-1.9.1.js"></script>
        <script src="js/jquery-ui.js"></script>
    </head> 
    <script type="text/javascript">
        $(document).ready(function() {
            var sid = window.location.search.substr(5);
            $.ajax({
                type: 'GET',
                url: "viewTopics",
                data: "id=" + sid,
                success: function(msg) {
                    var res = JSON.parse(msg);
                    for (var x = 0; x < res.length; x++) {
                        var str = "<a href='viewMaterial?tid=" + res[x].id + "&sid=" + sid + "'  id='s" + res[x].id + "'><h3>" + res[x].name + "</h3></a>";
                        $("#topicList").append("<li>" + str + "</li>");
                    }
                }
            });
            $.ajax({
                type: 'GET',
                url: 'viewSubjects',
                success: function(msg) {
                    var res = JSON.parse(msg);
                    for (var x = 0; x < res.length; x++) {
                        var str = "<a href='subjectpage.jsp?sid=" + res[x].id + "'  id='s" + res[x].id + "'><h3>" + res[x].name + "</h3></a>";
                        $("#subjectList").append("<li>" + str + "</li>");
                    }
                }
            });
        });
        //.$('#checkbutton').click(function(){
          //  var n = $('input[name=number]').val();
            //alert(n);
       // });
    </script>
    <body>  
        <h1 id="test"></h1>
        <!-- start header -->
        <div id="header">
            <div id="logo">
                <h1><a href="#"><span>e-learning</span>courses</a></h1>
                <p>easy way to study</p>
            </div>
            <div id="menu">
                <ul id="main">
                    <li class="current_page_item"><a href="index.jsp">Homepage</a></li>                
                    <li><a href="#">Test</a></li>
                    <li><a href="#">Forum</a></li>
                </ul>                
            </div>
        </div>
        <!-- end header -->
        <div id="wrapper">
            <!-- start page -->
            <div id="page">
                <div id="sidebar1" class="sidebar">
                    <ul>
                        <div id="sidebar1" class="sidebar">
                            <ul>
                                <li>
                                    <h2>Subjects</h2>
                                    <ul id="subjectList"> 
                                    </ul>

                                </li> 
                                <li>
                                    <h2>Topics</h2>
                                    <ul id="topicList"> 
                                    </ul>
                                </li> 
                            </ul>
                        </div> 
                    </ul>
                </div>
                <!-- start content -->
                <div id="content">
                    <div class="post">
                        <form id="searchform" method="post" action="checkTest"> 
                            <%    if (test != null) { 
                                    for (int i = 0; i < test.size(); i++) {
                            %>   
                            <h1 class="title"><%= test.get(i)%></h1> 
                            <input type="radio" name="group<%= j%>" value="<%= test.get(++i)%>"><%= test.get(i)%></input>
                            <input type="radio" name="group<%= j%>" value="<%= test.get(++i)%>"><%= test.get(i)%></input>
                            <input type="radio" name="group<%= j%>" value="<%= test.get(++i)%>"><%= test.get(i)%></input>
                            <input type="radio" name="group<%= j%>" value="<%= test.get(++i)%>"><%= test.get(i)%></input>
                            <input type="hidden" name="answer<%= j%>" value="<%= test.get(++i)%>"></input> 
                            <% j++;%> <br> 
                            <%} %> 
                            <input type="hidden" name="number" value="<%= j%>"></input> <br>
                            <input type="submit" id="chekbutton" value="Check" name="checkbutton"></input>
                        </form>
                        <% } else { %> 
                        <h1>Test was not loaded</h1>
                        <%}%> 
                    </div>               		
                </div>
                <!-- end content -->
                <!-- start sidebars -->
                <div id="sidebar2" class="sidebar">
                    <ul>
                        <li>
                            <form id="searchform" method="get" action="#">
                                <div>
                                    <h2>Site Search</h2>
                                    <input type="text" name="s" id="s" size="15" value="" />
                                </div>
                            </form>
                        </li>	
                           <li>
                        <% if(currentUser!=null){%>
                            <form id="searchform" method="get" action="logout">
                                <div>
                                    <h2><%= currentUser.getName() %></h2><br/>
                                    <input type="submit" value="Log out" />
                                </div>
                            </form> 
                        <% }%>
                        </li>
                         <% if (currentUser==null){%>
                        <li>
                            <form id="searchform" method="get" action="login">
                                <div>
                                    <h2>Login</h2>
                                    <input type="text" name="name" id="s" size="15" value="" placeholder="enter your name"/>
                                    <input type="text" name="password" id="s" size="15" value="" placeholder="enter your password"/>
                                    <input type="submit" value="Login" />
                                </div>
                            </form>
                        </li>
                        <li>
                            <form id="searchform" method="get" action="signup">
                                <div>
                                    <h2>Sign up</h2>
                                    <input type="text" name="name" id="s" size="15" value="" placeholder="enter your name"/>
                                    <input type="text" name="password" id="s" size="15" value="" placeholder="enter your password"/>
                                    <input type="text" name="email" id="s" size="15" value="" placeholder="enter your email"/>
                                    <input type="submit" name="s"   value="Sign up" />
                                </div>
                            </form>
                        </li>
                         <% }%> 
                        <li>
                            <form id="searchform" method="get" action="beginTest">
                                <div> 
                                    <h2>Test</h2>
                                    <input type="radio" name="complexity" value="1">easy</input>
                                    <input type="radio" name="complexity" value="2">medium</input>
                                    <input type="radio" name="complexity" value="3">difficult</input>
                                    <input type="submit" value="Begin test"></input>
                                </div>
                            </form>
                        </li>
                    </ul>
                </div>
                <!-- end sidebars -->
                <div style="clear: both;">&nbsp;</div>
            </div>
            <!-- end page -->
        </div>
        <div id="footer">
            <p class="copyright">&copy;&nbsp;&nbsp;2014 All Rights Reserved &nbsp;&bull;&nbsp;</p>
            <p class="link"><a href="#">Privacy Policy</a>&nbsp;&#8226;&nbsp;<a href="#">Terms of Use</a></p>
        </div>
    </body>
</html>









