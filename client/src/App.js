import Header from "./components/header";
import {Routes, Route} from 'react-router-dom';
import Dashboard from "./pages/dashboard";
import {CreateWorkSpaceProvider} from "./components/CreateWorkspaceDialogHook";
import CreateWorkspaceDialog from "./components/CreateWorkspaceDialog";

function App() {
  return (
    <CreateWorkSpaceProvider>
      <div >
        <Header />
        <Routes>
          <Route path={'/'} exact element={<Dashboard />}/>
        </Routes>
        <CreateWorkspaceDialog />
      </div>
    </CreateWorkSpaceProvider>
  );
}

export default App;
