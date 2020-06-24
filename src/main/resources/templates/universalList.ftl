<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<h3>Universal list</h3>
<br>
<div>
    <fieldset>
        <form name="search" action="" method="POST">
            <div class="search">
                Universal model:<@spring.formInput "searchForm.string" "" "text"/>
                <br>
            </div>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<br>

<a href="/" type="button" class="btn btn-light" style="float:left; margin-top:5px;"><i class="fa fa-chevron-circle-left"></i>Back to home page</a>

<a href="/web/universal/create" type="button" class="btn btn-light" style="float:right; margin-top:5px;"><i class="fa fa-plus-square-o"></i>Add new coup</a>

<br>
<div>
    <table class="table table-sm table-dark">
        <tr class="table-success">
            <th>ID</th>
            <th>Model<a href="/web/universal/list/sorted" type="button" class="btn btn-outline-light">
                                                              <i class="fa fa-sort-alpha-asc"></i></a> <a href="/web/universal/list" type="button" class="btn btn-outline-light">
                                                              <i class="fa fa-undo"></i>Undo sort</a></th>
            <th>Brand</th>
            <th>Producing country</th>
            <th>Graduation year</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        <#list universal as universal>
            <tr>
                <td>${universal.id}</td>
                <td>${universal.model}</td>
                <td>${universal.brand}</td>
                <td>${universal.producingCountry}</td>
                <td>${universal.graduationYear}</td>
                <td><a href="/web/universal/delete/${universal.id}"><button>Delete</button></a></td>
                <td><a href="/web/universal/edit/${universal.id}"><button>Edit</button></a></td>
            </tr>
        </#list>
    </table>
</div>

</body>
</html>