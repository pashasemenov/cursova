<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Technical data list</h3>
<br>
<div>
    <fieldset>
        <form name="search" action="" method="POST">
            <div class="search">
                 Technical data model:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
            </div>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<br>

<a href="/" type="button" class="btn btn-light" style="float:left; margin-top:5px;"><i class="fa fa-chevron-circle-left"></i>Back to home page</a>

<a href="/web/technicalData/create" type="button" class="btn btn-light" style="float:right; margin-top:5px;"><i class="fa fa-plus-square-o"></i>Add new</a>

<br>

<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Product code<a href="/web/technicalData/list/sorted" type="button" class="btn btn-outline-light">
                                                                     <i class="fa fa-sort-alpha-asc"></i></a> <a href="/web/technicalData/list" type="button" class="btn btn-outline-light">
                                                                     <i class="fa fa-undo"></i>Undo sort</a></th>
            <th>Body type </th>
            <th>Number of doors </th>
            <th>Number of seats </th>
            <th>Engine type </th>
            <th>location of the engine </th>
            <th>Engine displacement </th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list technicalData as technicalData>
            <tr>
                <td>${technicalData.id}</td>
                <td>${technicalData.productCode}</td>
                <td>${technicalData.bodyType}</td>
                <td>${technicalData.numberOfDoors}</td>
                <td>${technicalData.numberOfSeats}</td>
                <td>${technicalData.engineType}</td>
                <td>${technicalData.locationOfTheEngine}</td>
                <td>${technicalData.engineDisplacement}</td>
                <td><a href="delete/${technicalData.id}"><button>Delete</button></a></td>
                <td><a href="/web/technicalData/edit/${technicalData.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>