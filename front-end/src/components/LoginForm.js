import React from 'react';
import {Grid,Paper,Avatar,TextField,Button,Typography,Link} from '@mui/material'
import LockIcon from '@mui/icons-material/Lock';
import {Formik,Form} from 'formik'


 function LoginForm(){ 
    // const emailRef = useRef();
    // const passwordRef = useRef();
    
    const paperStyle={padding :20,height:'50vh',width:280,margin:'20px auto'}
    const avatarSytyle={backgroundColor:'black'}
    const btnstyle ={margin:'8px 0'}

    // function submitHandler(event){
    //     event.preventDefault();
       // Read the values

    //    const email = emailRef.current.value;
    //    const password = passwordRef.current.value;
    //    const user = { email,password};
    //    // call
    //     props.loginUser(user);
   //sdgsgs
    
    return (
        <section>
            <Grid>
                <Paper elevation ={10} style={paperStyle}>
                    <Grid align ='center'>
                        <Avatar style ={avatarSytyle}> <LockIcon/> </Avatar>
                        <h2>Sign In </h2> 
                    </Grid>   
                    <Formik>
                        {(props)=>(
                            <Form>
                                <TextField label = "Email" placeholder= "Enter email" fullWidth required/>
                    <TextField label = "Password" placeholder= "Enter password" type="password" fullWidth required/>
                    <Button type='submit' color='primary' variant="contained"  style={btnstyle}fullWidth> Sign in</Button>
                            </Form>
                            )
                        }

                    </Formik>
                    
                    <Typography>
                    <Link href="#" fullWidth required> Forgot Password ?</Link>
                    </Typography>
                    <Typography>
                    Don't have an account ?<Link href="/register"> Sign Up</Link>
                    </Typography>
                </Paper>
            </Grid>
            
        </section>
    );
}

export default LoginForm;
