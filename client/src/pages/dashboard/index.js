import {
  Container,
  Grid,
  Typography,
  Box,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
  ListItemButton,
  Avatar
} from "@mui/material";
import { deepOrange } from '@mui/material/colors';
import AddIcon from '@mui/icons-material/Add';
import style from './style.module.css';
import {CreateWorkSpaceConsumer as useCreateWorkSpace} from "../../components/CreateWorkspaceDialogHook";
import {useEffect, useState} from "react";
import DeleteIcon from '@mui/icons-material/Delete';
import {SERVER_HOST} from '../../config';
import CreateBoardDialog from "../../components/CreateBoardDialog";
import CreateWorkspaceDialog from "../../components/CreateWorkspaceDialog";
function Dashboard() {

  const [workspaces, setWorkspaces] = useState([{
    id: 1,
    workSpaceName: 'workspace 1'
  }]);
  const [refresh, setRefresh] = useState(true);
  const [boards, setBoards] = useState([{
    id: 1,
    boardName: 'Board1'
  }]);

  const [showCreateBoard, setShowCreateBoard] = useState(false);
  const {showCreateWorkSpaceDialog, hiddenCreateWorkSpaceDialog} = useCreateWorkSpace();
  const [currentWorkspace, setCurrentWorkspace] = useState(null);
  const [currentWorkspaceIndex, setCurrentWorkspaceIndex] = useState(0);
  useEffect(() => {
    setCurrentWorkspace(workspaces[currentWorkspaceIndex]);
  }, [workspaces, currentWorkspaceIndex])
  useEffect(() => {
    if (currentWorkspace) {
      fetch(SERVER_HOST + `/workspace/getBoards/${currentWorkspace.id}`)
        .then(res => res.json())
        .then(data => {
          setBoards(data);
        })
    }
  }, [currentWorkspace]);
  useEffect(() => {
    console.log(SERVER_HOST + '/user/getWorkspaces/'+7);
    fetch(SERVER_HOST + '/user/getWorkspaces/'+7)
      .then(res => res.json())
      .then(data => {
        setWorkspaces(data);
      })
  }, [refresh]);
  const handleCreateWorkspace = (name, description, type) => {
    fetch(SERVER_HOST + '/workspace/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        workSpaceName: name,
        workSpaceDescription: description,
        workSpaceType: type
      })
    }).then(res => {
      setRefresh(!refresh);
      hiddenCreateWorkSpaceDialog();
    })
  }
  const handleCreateBoard = (title, description) => {
    fetch(SERVER_HOST + '/board/add/'+currentWorkspace.id, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        boardName: title,
        boardDescription: description,
      })
    }).then(res => {
      setRefresh(!refresh);
      setShowCreateBoard(false);
    })
  }
  const handleClickRemoveBoard = (boardID) => {
    fetch(SERVER_HOST + `/board/deleteById/${boardID}`, {
      method: 'DELETE'
    }).then(res => {
      setRefresh(!refresh);
    })
  }
  const renderBoards = () => {
    return boards.map(board => {
      return (
        <Box className={style.board} key={board.id}>
          {board.boardName}
          <DeleteIcon className={style.deleteIcon}
                      onClick={() => handleClickRemoveBoard(board.id)}/>
        </Box>
      )
    })
  }
  const renderWorkspaceList = () => {
    return workspaces.map((workspace, index) => {
      return (
        <ListItem className={style.p0}
                  key={workspace.id}
                  onClick={() => {
                    setCurrentWorkspaceIndex(index);
                  }}>
          <ListItemButton selected={index === currentWorkspaceIndex}>
            <ListItemIcon>
              <Avatar variant={'rounded'} sx={{ bgcolor: deepOrange[500], width: '30px', height: '30px' }}>
                {workspace.workSpaceName[0]}
              </Avatar>
            </ListItemIcon>
            <ListItemText primary={workspace.workSpaceName}/>
          </ListItemButton>
        </ListItem>
      )
    })
  }
  return (
    <Container>
      <CreateWorkspaceDialog onSubmit={handleCreateWorkspace}/>
      <CreateBoardDialog show={showCreateBoard}
                         onSubmit={handleCreateBoard}
                         onClose={() => setShowCreateBoard(false)}/>
      <Grid container spacing={1}>
        <Grid item xs={3}>
          <Box className={style.titleRow} marginTop={'40px'}>
            <Typography>WORKSPACE</Typography>
            <AddIcon data-testid={'create'} style={{cursor: 'pointer'}} onClick={() => showCreateWorkSpaceDialog()}/>
          </Box>
          <List className={style.p0}>
            {renderWorkspaceList()}
          </List>
        </Grid>
        <Grid item xs={9}>
          {currentWorkspace && (
            <>
              <Box style={{
                height: '150px',
                marginTop: '20px',
                background: 'whitesmoke',
                border: '2px solid gainsboro',
                boxSizing: 'border-box',
                padding: '40px'}}>
                <Box display={'flex'}>
                  <Avatar variant={'rounded'} sx={{ bgcolor: deepOrange[500], width: '50px', height: '50px' }}>
                    {currentWorkspace.workSpaceName[0]}
                  </Avatar>
                  <Typography variant={'h6'} marginLeft={'10px'}>{currentWorkspace.workSpaceName}</Typography>
                </Box>
              </Box>
              <Box boxSizing={'border-box'} padding={'10px'} display={'flex'} flexWrap={'wrap'}>
                <Box className={style.createBoard}
                     onClick={() => setShowCreateBoard(true)}
                >Create New Board</Box>
                {renderBoards()}
              </Box>
            </>
          )}
        </Grid>
      </Grid>
    </Container>
  )
}

export default Dashboard;