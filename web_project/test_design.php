<?php

$connect = mysqli_connect("localhost", "root", "autoset", "informoney");
$query = "select *  from totalscore where model like '%미로%'";
$result = mysqli_query($connect,$query);
echo $_GET[model1];
echo $_GET[model2];

?>

<!DOCTYPE html>
<html>
   <head>
      <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['감정분석결과','점수'],
            <?php
            
            while($row = mysqli_fetch_array($result))
            {
               echo "['"."긍정"."', ".$row["positive"]."],";
               echo "['"."부정"."', ".$row["negative"]."],";
               echo "['"."중립"."', ".$row["neutral"]."],";
            }
            ?>
            ]);
        var options = {
          title: '긍정도'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>