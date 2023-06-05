// 1. 유저가 값을 입력한다.
// 2. + 버튼을 클릭하면, 할일이 추가되어진다.
// 3. delete 버튼을 누르면 할일이 삭제되어진다.
// 4. check 버튼을 누르면 할일이 끝나면서 취소선이 그어진다.
// 5. 진행중, 끝남 탭을 누르면 할일이 끝나면서 ,언더바가 이동한다.
// 6. 끝남탭은, 끝난 아이템만, 진행중인 탭은 진행중인 아이템만
// 7. 전체탭을 누르면 다시 전체 아이템으로 돌아옴.

// const uniqueId = Math.random().toString(36).substr(2, 9);

let taskInput = document.getElementById("task-input");
console.log(taskInput);
let addButton = document.getElementById("add-button");
let taskList = [];

addButton.addEventListener("click", addTask);

function addTask(){
    // console.log("click되는지 확인해 볼까요????");
    let taskContent = taskInput.value;
    taskList.push(taskContent);
    console.log(taskList);

    render();
}

function render() {
    let resultHTML = "";
    for (i = 0; i < taskList.length; i++) {
        resultHTML += `<div class="task">
        <div>${taskList[i]}</div>
        <div>
          <button>Check</button>
          <button>Delete</button>
        </div>
      </div>`;
    }
    document.getElementById("task-board").innerHTML = resultHTML;
}