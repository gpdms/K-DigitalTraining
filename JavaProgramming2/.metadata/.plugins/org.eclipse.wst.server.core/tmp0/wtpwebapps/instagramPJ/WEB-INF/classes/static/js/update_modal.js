//------글 수정 모달-----//
  const body = document.querySelector("body");
  const updateMd = document.querySelector('.updateMd');
  const upBtn = document.getElementById("upBtn");
  const upCloseBtn = document.getElementById("upCloseBtn");

  function modalOpen() {
    updateMd.style.display = "block";
    body.style.overflow = "hidden";
  }
  function modalClose() {
    updateMd.style.display = "none";
    body.style.overflow = "auto";
  }

  // 클릭시 모달오픈
  upBtn.addEventListener('click', modalOpen);
  
  // 외부 클릭시 모달창닫음
  window.addEventListener('click', (e) => {
    e.target === updateMd ? modalClose() : false
  })
  upCloseBtn.addEventListener('click', modalClose);