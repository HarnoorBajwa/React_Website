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
function Dashboard() {
  const {showCreateWorkSpaceDialog} = useCreateWorkSpace();
  return (
    <Container>
      <Grid container spacing={1}>
        <Grid item xs={2}>
          <Box className={style.titleRow} marginTop={'40px'}>
            <Typography>WORKSPACE</Typography>
            <AddIcon style={{cursor: 'pointer'}} onClick={() => showCreateWorkSpaceDialog()}/>
          </Box>
          <List className={style.p0}>
            <ListItem className={style.p0}>
              <ListItemButton >
                <ListItemIcon>
                  <Avatar variant={'rounded'} sx={{ bgcolor: deepOrange[500], width: '30px', height: '30px' }}>T</Avatar>
                </ListItemIcon>
                <ListItemText primary="Inbox"/>
              </ListItemButton>
            </ListItem>
          </List>
        </Grid>
        <Grid item xs={10}></Grid>
      </Grid>
    </Container>
  )
}

export default Dashboard;