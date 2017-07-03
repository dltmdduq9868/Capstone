<?php
$conn = mysqli_connect("localhost", "root", 458658);//서버접속
mysqli_select_db($conn, "scrapy");//DB선택

?>

<!DOCTYPE html>
<html>
<head>
     <meta charset="utf-8">
     <link rel="stylesheet" type="text/css" href="http://localhost/web_project/style.css">
</head>
<body id="target">
    <header>
    <img src="data:image/jpeg;base64,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" alt="naver_shopping_image">
        
       
  </header>
<!-- model_url db초기화 및 생성     -->
    <?php 
//     $drop_model_url = "DROP TABLE IF EXISTS `model_url`";
    
//     if(mysqli_query($conn,$drop_model_url)){
//     	echo "model_url 테이블 삭제 후";
//     }else{
//     	echo "model_url 테이블 삭제 오류:".mysqli_errno($conn);
//     }
    
//     $sql_model_url = "CREATE TABLE `model_url` (
//   `id` int(4) auto_increment NOT NULL,
//   `category` varchar(10) character set utf8 default NULL,
//   `model` varchar(100) character set utf8 default NULL,
//   `url` varchar(100) character set utf8 default NULL,
//    PRIMARY KEY (`id`)
// 	)";
// 	if(mysqli_query($conn,$sql_model_url)){
//     	echo " 생성";
//     }else{
//     		echo "model_url 테이블 생성 오류:".mysqli_errno($conn);
//     	}
    
//     	echo "<br />";


//  	?>
<!-- <!-- input db초기화 및 생성	 --> 
 	    <?php 
    $drop_input = "DROP TABLE IF EXISTS `input`";
    
    if(mysqli_query($conn,$drop_input)){
    	echo "input 테이블 삭제 후";
    }else{
    	echo "input 테이블 삭제 오류:".mysqli_errno($conn);
    }
    
    $sql_input = "CREATE TABLE `input` (
  `id` tinyint(4) auto_increment NOT NULL,
  `keyword` varchar(10) character set utf8 default NULL,
   PRIMARY KEY (`id`))";
	if(mysqli_query($conn,$sql_input)){
    	echo " 생성";
    }else{
    		echo "input 테이블 생성 오류:".mysqli_errno($conn);
    	}
    
    	echo "<br />";
   
 	?>

<!-- 검색된 상품을 db에 넣는다.  -->
    <?php 
    #
    $result = $_POST["model"];
//     echo "<br />";
//     echo "검색상품...".$result;
    $result = mysqli_query($conn, "INSERT INTO input (keyword) VALUES ('$result')");
//     if(mysqli_query($conn,$result)){
//     	echo $result." DB저장 성공";
//     }else{
//     	echo $result." DB저장 실패:".mysqli_errno($conn);
//     }  
    
    ?>
    
<!--         <nav>  -->
<!--         <ol> -->
    <?php
    $test = array(); // 빈 배열인 경우
    $i = 0;
    $result = $_POST["model"];
    
    $result = mysqli_query($conn, "SELECT * FROM model_url WHERE category LIKE '%$result%'");
//     $result = mysqli_query($conn, "SELECT model FROM model_url WHERE category LIKE '%".$result."%'");
    while( $row = mysqli_fetch_assoc($result)){//질의한 결과를 가지고 온다.
//     	echo  $row['model'];
//     	echo "<br />\n";
//     	if($row['model']!='NULL')
//     	echo $row['model'];
//     	echo "<br />\n";
    	
    	if($row['model']!='NULL'){
    	$test[$i] = $row['model'];
    	$i = $i + 1;
    	}
    }
    
    ?>
<!--     <nav> -->
<table class="mono_table">

<tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_9354379/9354379320.20160129101419.jpg?type=f300"></th>
            <td><a href=http://localhost/web_project/design.php?model1=<?=$test[0]?>><?=$test[0]?></a>
            <br><br>
            최대분무량 : 220cc|물탱크용량 : 2.5ℓ|가습방식 : 초음파식|작동방식 : 다이얼식|연속가습시간 : 12시간|소비전력 : 30W|기타특징 : 상부급수|가습기능 : 초미세가습|
            </td>
            
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_1033490/10334907166.20161010104205.jpg?type=f300  "></th>
            <td><a href=http://localhost/web_project/design.php?model2=<?=$test[1]?>><?=$test[1]?></a>
            <br><br>
            최대분무량 : 500cc|물탱크용량 : 4.0ℓ|가습방식 : 초음파식|작동방식 : 터치식|연속가습시간 : 26시간|소비전력 : 36W|기타특징 : 물없음알림, 타이머, 저소음, 무드램프
            </td>
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_1094194/10941940201.20170118155600.jpg?type=f300  "></th>
            <td><a href=http://localhost/web_project/design.php?model3=<?=$test[2]?>><?=$test[2]?></a>
            <br><br>
            최대분무량 : 300cc|가습방식 : 초음파식|연속가습시간 : 13시간|소비전력 : 38W
           </td>
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_1031467/10314671660.20161114110801.jpg?type=f300 "></th>
            <td><a href=http://localhost/web_project/design.php?model4=<?=$test[3]?>><?=$test[3]?></a>
            <br><br>
            최대분무량 : 250cc|물탱크용량 : 2.3ℓ|가습방식 : 초음파식|작동방식 : 다이얼식|연속가습시간 : 10시간|소비전력 : 24W|기타특징 : 물없음알림, 저소음, 상부급수, 무드램프
            </td>
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_1033491/10334917292.20160914105338.jpg?type=f300"></th>
            <td><a href=http://localhost/web_project/design.php?model5=<?=$test[4]?>><?=$test[4]?></a>
            <br><br>
            최대분무량 : 250cc|물탱크용량 : 2.5ℓ|가습방식 : 초음파식|연속가습시간 : 10시간|소비전력 : 35W|기타특징 : 상부급수, 무드램프|최대소음 : 25dB|분무구 : 양방향
            </td>
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_6004840/6004840565.20120211205718.jpg?type=f300 "></th>
            <td><a href=http://localhost/web_project/design.php?model6=<?=$test[5]?>><?=$test[5]?></a>
            <br><br>
             FG-001가습방식 : 초음파식|작동방식 : 터치식|연속가습시간 : 8시간|소비전력 : 2.5W|기타특징 : USB전원, 무드램프|가습기능 : 아로마가습|분무구 : 단방향|초음파식, 단방향분무
             </td>
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_6667236/6667236112.20121108120044.jpg?type=f300 "></th>
            <td><a href=http://localhost/web_project/design.php?model7=<?=$test[6]?>><?=$test[6]?></a>
            <br><br>
            최대분무량 : 180cc|물탱크용량 : 1.6ℓ|가습방식 : 초음파식|작동방식 : 버튼식|연속가습시간 : 9시간|소비전력 : 23W|기타특징 : 물없음알림|분무구 : 단방향|전자식, 1.6ℓ
            </td>
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_6726447/6726447005.20151007182536.jpg?type=f300 "></th>
            <td><a href=http://localhost/web_project/design.php?model8=<?=$test[7]?>><?=$test[7]?></a>
            <br><br>
             FG-001가습방식 : 초음파식|작동방식 : 터치식|연속가습시간 : 8시간|소비전력 : 2.5W|기타특징 : USB전원, 무드램프|가습기능 : 아로마가습|분무구 : 단방향|초음파식, 단방향분무
             </td>
        </tr>
        <tr>
            <th scope="row"><img class='image_width' src="http://shopping.phinf.naver.net/main_5476313/5476313604.20120211200317.jpg?type=f300 "></th>
            <td><a href=http://localhost/web_project/design.php?model9=<?=$test[8]?>><?=$test[8]?></a>
            <br><br>
            물탱크용량 : 1.5ℓ|가습방식 : 초음파식|작동방식 : 다이얼식|소비전력 : 35W|기타특징 : 투명수위창, 물없음알림, PET병사용, 무드램프|분무구 : 단방향|기계식, 1.5ℓ, 단방향
            </td>
        </tr>


<!--     </nav> -->



<!--         </ol> -->
<!--     </nav> -->
  
</body>
</html>