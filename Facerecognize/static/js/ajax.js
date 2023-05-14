function getQueryString(name) {
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
var r = window.location.search.substr(1).match(reg);
if (r != null) return unescape(r[2]); return null;
}

 function rec() {
    $.ajax({
        url:"/Facerecognize/solve/",
        method:"POST",
        data:{},
        success:function(data){
            console.log("success");
            console.log(data);
            if(data=='{"data":"success"}'){alert("考勤成功");}
            else{
                alert("人脸与库中人脸不匹配");                
            }

            
        },
        error:function (data) {
            console.log("error");
            console.log(data);
            window.location.reload();
        }
    });
 }
a="null";
 fileUploader = document.getElementById('photo');
fileUploader.addEventListener('change', (event) => {
   files = event.target.files;
  console.log('files', files);
console.log('files', files[0]["name"]);
a=files[0]["name"];
});

 function upload(){
    uid=getQueryString("Uid");
$.ajax({
        
        url:"/Facerecognize/upload/",
        method:"POST",
        data:{
            "name":a,
            "uid":uid
        },
        success:function(data){
            console.log("success");
            console.log(data);
            if(data=='{"data":"success"}'){alert("上传成功");}
            else{
                alert("上传失败");                
            }

            
        },
        error:function (data) {
            console.log("error");
            console.log(data);
            alert("上传失败");
            window.location.reload();
        }
    });
 }

function loadname(){
    uid=getQueryString("Uid");
    let mes = $("#name").html();
    mes+='"<i class="glyphicon glyphicon-user"></i>'+uid+'<span class="caret"></span>"';
    $("#name").html(mes);
}

 function test(){
    uid=getQueryString("Uid");
$.ajax({
        
        url:"/Facerecognize/test/",
        method:"POST",
        data:{
            "name":a,
        },
        success:function(data){
            console.log("success");
            console.log(data);
            if(data=='{"data":"success"}'){alert("考勤成功");}
            else{
                alert("人脸与库中人脸不匹配");                
            }

            
        },
        error:function (data) {
            console.log("error");
            console.log(data);
            alert("人脸与库中人脸不匹配");
            window.location.reload();
        }
    });
 }