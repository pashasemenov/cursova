<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<style>
    * {
        background-color: #59ffa0;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="coupe" action="" method="POST">
    Product code:
    <br>
    <@spring.formInput "technicalDataForm.productCode" "" "text"/>
    <br>
    Body type:
    <br>
    <@spring.formInput "technicalDataForm.bodyType", "", "text"/>
    <br>
    Number of doors :
    <br>
    <@spring.formInput "technicalDataForm.numberOfDoors", "", "text"/>
    <br>
    Number of seats:
    <br>
    <@spring.formInput "technicalDataForm.numberOfSeats", "", "text"/>
    <br>
    Engine type
    <br>
    <@spring.formInput "technicalDataForm.engineType", "", "text"/>
    <br>
    location of the engine
    <br>
    <@spring.formInput "technicalDataForm.locationOfTheEngine", "", "text"/>
    <br>
    Engine displacement
    <br>
    <@spring.formInput "technicalDataForm.engineDisplacement", "", "text"/>
    <br>
    <input type="submit" value="Create"/>
</form>

</body>
</html>