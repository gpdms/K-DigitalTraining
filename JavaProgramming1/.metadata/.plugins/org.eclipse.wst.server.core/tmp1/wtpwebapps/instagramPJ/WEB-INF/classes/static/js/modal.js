 //------프로필 모달-----//
  const body = document.querySelector("body");
  const profileMd = document.querySelector('.profileMd');
  const pfBtn = document.getElementById("pfBtn");
  const pfCloseBtn = document.getElementById("pfCloseBtn");

  function modalOpen() {
    profileMd.style.display = "block";
    body.style.overflow = "hidden";
  }
  function modalClose() {
    profileMd.style.display = "none";
    body.style.overflow = "auto";
  }

  // 클릭시 모달오픈
  pfBtn.addEventListener('click', modalOpen);
  
  // 외부 클릭시 모달창닫음
  window.addEventListener('click', (e) => {
    e.target === profileMd ? modalClose() : false
  })
  pfCloseBtn.addEventListener('click', modalClose);
  
  
// 프로필 이미지 변경 미리보기  
   var fileInput  = document.querySelector( "#id_photo" ),
       button     = document.querySelector( ".input-file-trigger" ),
       the_return = document.querySelector(".file-return");

   // Show image
   fileInput.addEventListener('change', handleImage, false);
   var canvas = document.getElementById('imageCanvas');
   var ctx = canvas.getContext('2d');


    function handleImage(e){
       var reader = new FileReader();
       reader.onload = function(event){
           var img = new Image();
           // var imgWidth =
           img.onload = function(){
               canvas.width = 50;
               canvas.height = 50;
               ctx.drawImage(img,0,0,50,50);
           };
           img.src = event.target.result;
           // img.width = img.width*0.5
           // canvas.height = img.height;
       };
       reader.readAsDataURL(e.target.files[0]);
   }



