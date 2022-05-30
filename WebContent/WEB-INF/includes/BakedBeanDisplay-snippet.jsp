<H1>Repeated Baked Bean Value: request-based Sharing</H1>
<jsp:useBean id="requestBean" class="chapter14.BakedBean" scope="page"></jsp:useBean>
<H2>Bean Level:
<jsp:getProperty property="Level" name="requestBean"/></H2>
<H2>Dish bean goes with:
<jsp:getProperty name="requestBean" property="goesWith" /></H2>