import React,{useEffect,useState} from "react";
import ViewBoards from '../components/ViewBoards'

function Boards(){
    /* ToDO: Create state using useState hook for boards data */
    const [boardsData,setBoardsData] = useState([]);

    function getAlllBoards(){
        /* ToDo: Implement getAllBoards function*/
        fetch('http://localhost:9001/board/getAllBoards')
        .then(response => response.json())
        .then(boards => {
            setBoardsData(boards);

        });
    };

    // function deleteBoard(){
    //     /*ToDo: Implement Delete Board function*/
    //     fetch('http://localhost:9001/user/save',{
    //         method: 'POST',
    //         body :JSON.stringify(values),
    //         headers: { 'Content-Type': 'application/json'}

    //     }).then(() => history.replace('/login'));
    // }

    /* ToDo: Use useEffect hook to call getAllBoards()*/
    useEffect(function(){
        getAlllBoards();
    },[])

    return(
        <section>
            <ViewBoards /* ToDo: Pass the state variable as props*/ boards={boardsData}/>
        </section>
    )
}

export default Boards;
