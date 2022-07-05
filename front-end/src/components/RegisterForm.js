import React from 'react'
import { Grid, Paper, Avatar, Typography, TextField, Button} from '@mui/material'
import AddCircleOutlineOutlinedIcon from '@mui/icons-material/AddCircleOutlineOutlined';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import {Formik,Field,Form,ErrorMessage} from 'formik'
import * as Yup from 'yup'
import { color } from '@mui/system';


 function RegisterForm(){
    const paperStyle = { padding: '30px 20px', width: 300, margin: "20px auto" }
    const shadowOffset = { width: 0 ,height: 1}
    const headerStyle = { margin: 0 }
    const avatarStyle = { backgroundColor: 'blue' }
    const btnstyle = {backgroundColor:'black'}
    const initialValues={
        name:'',
        email:'',
        password:'',
        confirmPassword:'',
        securityQuestion:'',
        termsConditions:false
    }
    
    const validationSchema = Yup.object().shape({
        name: Yup.string().min(3, "It's too short").required("Required"),
        email: Yup.string().email("Enter valid email").required("Required"),
        password: Yup.string().required('This Required').matches(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/,
        "Must Contain 8 Characters, One Uppercase, One Lowercase, One Number and One Special Case Character")
    })
    // const uppercaseRegExp   = /(?=.*?[A-Z])/;
    // const lowercaseRegExp   = /(?=.*?[a-z])/;
    // const digitsRegExp      = /(?=.*?[0-9])/;
    // const specialCharRegExp = /(?=.*?[#?!@$%^&*-])/;
    const submitHandler=(values,props)=>{
        console.log(values)
    }

 
     return (
         <Grid>
             <Paper elevation={20} style={paperStyle} shadowColor='#000' Offset={shadowOffset} shadowOpacity='0.8'
                 shadowRadius='2' >
                 <Grid align='center'>
                     <Avatar style={avatarStyle}>
                         <AddCircleOutlineOutlinedIcon />
                     </Avatar>
                     <h2 style={headerStyle}>Sign Up</h2>
                     <Typography variant='caption' gutterBottom>Please fill this form to create an account !</Typography>
                 </Grid>
                 <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={submitHandler}>
                     {(props) => (
                         <Form>
                             <Field as={TextField} fullWidth name='name' label='Name' placeholder="Enter your Name" 
                             helperText={<ErrorMessage name="name" />} />
                             <Field as={TextField} fullWidth name='email' label='Email' placeholder="Enter your email"
                              helperText={<ErrorMessage name="email" />}/>
                             <Field as={TextField} fullWidth name='password' label='Password' placeholder="Enter your password" type="password" 
                             helperText={<ErrorMessage name="password" />}/>
                             <Field as={TextField} fullWidth name='confirmPassword' label='Confirm Password' placeholder="Confirm your password"
                              type="password" helperText={<ErrorMessage name="confirmPassword" />} />
                             <p> Who is your favourite singer ?</p>
                             <Field as={TextField} fullWidth name='securityQuestion' label='Type here' placeholder="Enter you answer" 
                             helperText={<ErrorMessage name="securityQuestion" />}/>
                             <FormControlLabel
                                 control={<Field as={Checkbox} name="termsConditions" />}
                                 label="I accept the terms and conditions."
                             />
                             <Button type='submit' style={btnstyle} variant='contained' color='primary' >{props.isSubmitting ? "Loading" : "Create Account"}</Button>


                         </Form>

                     )}
                 </Formik>
             </Paper>
         </Grid>
     )
}


export default RegisterForm;