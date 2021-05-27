<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Infomation Required</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <body style="background-color:#19875440;">
        <div class="px-4 pt-5 my-5" >
            <h1 class="display-1 text-center">Please tell us some more information</h1>
            <div class="border shadow-lg px-5 py-3 my-5 mx-auto col-lg-4 col-md-8" style="background-color:#dee2e6c7;">
                <form class="ml-5" action="/form" name="form" method="POST">
                    <div class="my-3">
                        <label for="InputEmail" class="form-label">Email Address: </label>
                        <input type="email" class="form-control" id="InputEmail" name="email" value="${(user.email)!''}" />
                    </div>
                    <div class="my-3">
                        <label for="InputPhone" class="form-label">Phone Number: </label>
                        <input type="text" class="form-control" id="InputPhone" name="phone" value="${(user.phone)!''}" />
                    </div>
                    <div class="my-3">
                        <p> Are you interested in our program? </p>
                        <label class="radio-inline">
                            <input class="form-check-input" type="radio" name="status" id="InputStatus" value="yes" checked>
                            Yes
                        </label>
                        <label class="radio-inline mx-3">
                            <input class="form-check-input" type="radio" name="status" id="InputStatus" value="no">
                            No
                        </label>
                    </div>
                    <div class="my-3">
                        <label for="InputMessage">Anything you want to say: </label>
                        <textarea class="form-control" id="InputMessage" name="message" rows="3">${(user.message)!""}</textarea>
                    </div>
                    <input class="btn btn-primary mt-3" type="submit" value="Submit"/>
                </form>

                <#if errorMessage?has_content>
                    <div class="error text-danger ml-5">${errorMessage}</div>
                </#if> 
            </div>    
        </div>
    </body>
</html>