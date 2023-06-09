# K-DigitalTraining   
+ 과정명 : 프로젝트 기반 자바(JAVA) 응용 SW개발자(풀스택) 취업과정   
+ 훈련기간 : 2022-11-03 - 2023-05-09
----------------------------------------------
<br/>

## :computer: 웹표준 (프론트엔드)
+ [11/03 ~ 11/17](https://github.com/gpdms/K-DigitalTraining/tree/main/frontend)
HTML5, CSS3, Javascript, JQuery   


+ **1차 팀프로젝트 : 웹프로젝트**
  - [소스코드](https://github.com/gpdms/K-DigitalTraining/blob/main/frontend/%EC%9B%B9%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8/%EC%B5%9C%EC%A2%85.html)
  - 기간: 22/11/18 ~ 22/11/22 (3일)
  - 팀원: 총 3명
    <details>
    <summary>화면 및 담당부분</summary>
    <div markdown="1">       
    <img width="90%" alt="홈화면" src="https://github.com/gpdms/K-DigitalTraining/assets/118142992/6b7aa239-db6c-4b49-a595-50a8f7117218"><br/>
    <img width="90%" alt="모달" src="https://github.com/gpdms/K-DigitalTraining/assets/118142992/3803e828-916d-4753-a417-4860d3115777"><br/>
     <img width="90%" alt="모달" src="https://github.com/gpdms/K-DigitalTraining/assets/118142992/3ff79f03-d846-44c8-a03c-f21fad099e3d"><br/>
     **헤더 HTML**
     ```
    <header id="top">
      <span id="menu-button"></span>
      <div id="profile">
        <span id="profile-img"></span>
        <a href="#" id="profile-name">IUtheBEST</a>
        <span id="settings"></span>
        <!-- 아이콘링크명시하기<a target="_blank" href="https://icons8.com/icon/54151/%EA%B8%B0%EC%96%B4">기어</a> icon by <a target="_blank" href="https://icons8.com">Icons8</a> -->
        <p id="user-name">이지은 님</p>
      </div>
      <span id="upload-button"></span>

      <p class="arrow" id="arrow-img">프로필 사진 변경</p>
      <p class="arrow" id="arrow-upload">업로드</p>
    </header>
     ```
     **헤더 JavaScript**
     ```
     //스크롤 시 헤더 줄어듦
      window.onscroll = function () { scrollFunction() };
      function scrollFunction() {
        if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {

          document.getElementById("top").style.height = "50px";
          document.getElementById("settings").style.display = "none";
          document.getElementById("user-name").style.display = "none";

          let elementProfile = document.getElementById("profile");
          elementProfile.style.cssText = "width: 20%; height: 50px; margin-top: 0; float: left; margin-left: 500px;"

          let elementImg = document.getElementById("profile-img");
          elementImg.style.cssText = "width: 46px; height: 46px; margin-top: 2px;"

          let elementName = document.getElementById("profile-name");
          elementName.style.cssText = "line-height: 46px; font-size: 18px; margin-top: 0;"

          let elementUpload = document.getElementById("upload-button");
          elementUpload.style.cssText = "width:46px; height: 46px; margin-top: 1px; margin-right: 100px;"

          // 마우스오버 이벤트 제거
          elementImg.addEventListener("mouseover", function () {
            document.getElementById("arrow-img").style.display = "none";
          });

          elementUpload.addEventListener("mouseover", function () {
          document.getElementById("arrow-upload").style.display = "none";
          });


          //스크롤 위로 올리면 헤더 다시 원래대로
        } else {
          document.getElementById("top").style.height = "260px";
          document.getElementById("settings").style.display = "inline";
          document.getElementById("user-name").style.display = "inline";

          let elementProfile = document.getElementById("profile");
          elementProfile.style.cssText = "display: inline-flex;margin-top: 45px; margin-left: 400px; width: 30%;"

          let elementImg = document.getElementById("profile-img");
          elementImg.style.cssText = "width: 150px; height: 150px;"

          let elementName = document.getElementById("profile-name");
          elementName.style.cssText = "line-height: 150px; font-size: 24px; margin-left: 30px;"

          let elementUpload = document.getElementById("upload-button");
          elementUpload.style.cssText = "width:120px; height: 120px; margin-top: 65px; margin-right: 200px;"

          //마우스오버 이벤트 생성
          elementImg.addEventListener("mouseover", function () {
            document.getElementById("arrow-img").style.display = "inline-block";
          });
          elementUpload.addEventListener("mouseover", function () {
            document.getElementById("arrow-upload").style.display = "inline-block";
          });

        }
      };

      //모달부분
      let body = document.querySelector("body");
      let modal = document.querySelector('.modal');
      let settings = document.getElementById("settings");
      let profileName = document.getElementById('profile-name');

      function modalOpen() {
        modal.style.display = 'block';
        body.style.overflow = "hidden";
      }
      function modalClose() {
        modal.style.display = "none";
        body.style.overflow = "auto";
      }

      // 클릭시 모달오픈
      settings.addEventListener('click', modalOpen);
      profileName.addEventListener('click', modalOpen);

      // 외부 클릭시 모달창닫음
      window.addEventListener('click', (e) => {
        e.target === modal ? modalClose() : false
      })


      //마우스 오버시 말풍선
      //프로필이미지 오버시 말풍선
      let profileImg = document.getElementById("profile-img");

      profileImg.addEventListener("mouseover", function () {
        let arrowImg = document.getElementById("arrow-img");
        arrowImg.style.display = "inline-block";
      });
      profileImg.addEventListener("mouseleave", function () {
        let arrowImg = document.getElementById("arrow-img");
        arrowImg.style.display = "none";
      });

      //업로드버튼 오버시 말풍선
      let uploadButton = document.getElementById("upload-button");

      uploadButton.addEventListener("mouseover", function () {
        let arrowUpload = document.getElementById("arrow-upload");
        arrowUpload.style.display = "block";
      });
      uploadButton.addEventListener("mouseleave", function () {
        let arrowUpload = document.getElementById("arrow-upload");
        arrowUpload.style.display = "none";
      });
     ```
     **헤더 CSS**
     ```
       #top {
      width: 1250px;
      height: 260px;
      /* border: 1px solid #ccc; */
      background-color: gainsboro;
      transition: 0.4s;
      position: fixed;
      z-index: 1;
      top: 0;
    }

    #menu-button {
      position: absolute;
      left: 25px;
      top: 5px;
      width: 40px;
      height: 40px;
      background: url(toggle_button.jpg);
      cursor: pointer;
      z-index: 2;
    }

    #profile {
      display: inline-flex;
      margin-top: 45px;
      margin-left: 400px;
      width: 30%;
      /* border: 1px solid black; */

    }

    #profile-img {
      background: url(profile-img.jpg);
      background-size: cover;
      width: 150px;
      height: 150px;
      border-radius: 50%;
      cursor: pointer;
    }

    #profile-name {
      text-decoration: none;
      color: #444;
      line-height: 150px;
      text-align: center;
      font-size: 24px;
      margin-left: 30px;
      font-weight: 500;
    }

    #user-name {
      margin-left: -150px;
      margin-top: 100px;
      font-size: 20px;
      color: #444;
    }

    #settings {
      background: url(gear-icon.png);
      background-size: cover;
      width: 30px;
      height: 30px;
      margin-top: 58px;
      margin-left: 25px;
      cursor: pointer;

    }

    #upload-button {
      /* display: inline-flex; */
      background: url(plus-icon.png);
      background-size: cover;
      width: 120px;
      height: 120px;
      float: right;
      margin-top: 65px;
      margin-right: 200px;
      cursor: pointer;
    }

    .modal {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      display: none;


      background-color: rgba(0, 0, 0, 0.4);
      z-index: 5;
      overflow: hidden;
    }

    .modal-body {
      position: fixed;
      top: 50%;
      left: 50%;

      width: 250px;
      height: 300px;

      padding: 40px;

      text-align: center;
      color: black;

      background-color: rgb(255, 255, 255);
      border-radius: 10px;
      box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);

      transform: translateX(-50%) translateY(-50%);
      z-index: 6;
      overflow: hidden;
    }

    .modal-body {
      margin: 0;
      padding: 0;
    }

    .modal-body ul {
      list-style: none;
      margin-top: 0;
      padding: 0;
    }

    .modal-body ul li {
      display: block;
      padding: 20px;
    }

    .modal-body ul li a {
      text-decoration: none;
      font-size: 1em;
      color: #555;
    }

    .modal-body ul li:hover {
      background: #f1f1f1;
    }

    .modal-body ul li a:hover {
      text-decoration: underline;
    }

    .arrow {
      position: absolute;
      width: 120px;
      padding: 8px;
      -webkit-border-radius: 8px;
      -moz-border-radius: 8px;
      border-radius: 8px;
      background: #333;
      color: #fff;
      font-size: 14px;
      text-align: center;
    }

    .arrow:after {
      position: absolute;
      bottom: 100%;
      left: 50%;
      width: 0;
      height: 0;
      margin-left: -10px;
      border: solid transparent;
      border-color: rgba(51, 51, 51, 0);
      border-bottom-color: #333;
      border-width: 10px;
      pointer-events: none;
      content: ' ';
    }

    #arrow-img {
      display: none;
      top: 195px;
      left: 410px;

    }

    #arrow-upload {
      display: none;
      right: 190px;
      bottom: 15px;

    }
     ```
     
    </div>
    </details>



## :computer: 자바 & 백엔드
