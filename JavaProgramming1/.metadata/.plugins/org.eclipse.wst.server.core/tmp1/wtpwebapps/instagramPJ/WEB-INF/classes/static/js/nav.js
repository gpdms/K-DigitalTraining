
 //----------------사이드바 script------------------//
      //사이드바 열기 닫기
      let menuBtn = document.getElementById("menu-button");
      let closeBtn = document.getElementById("close-button");
      let sideBar = document.getElementById("sidebar");
      //console.log(sideBar.style.display);
      
      menuBtn.addEventListener("click", function(){
		//console.log(menuBtn);
		//console.log(sideBar);
        if(sideBar.style.display == "inline-block"){
          sideBar.style.display = "none";
        } else if(sideBar.style.display == "none" ) {
          sideBar.style.display = "inline-block";
      	}
      });

      //닫기버튼
      closeBtn.addEventListener("click",function(){
        sideBar.style.display = "none";
      });


      


