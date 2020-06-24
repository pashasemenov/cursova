<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        background-image: url(https://img.mercedes-benz-kiev.com/data/lineup/c-class-coupe/c-class-coupe-3.jpeg);
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;);
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="coupe" action="" method="POST">
    Model:
    <br>
    <@spring.formInput "coupeForm.model" "" "text"/>
    <br>
    Brand:
    <br>
    <@spring.formInput "coupeForm.brand", "", "text"/>
    <br>
    Producing country :
    <br>
    <@spring.formInput "coupeForm.producingCountry", "", "text"/>
    <br>
    Graduation year:
    <br>
    <@spring.formInput "coupeForm.graduationYear", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>