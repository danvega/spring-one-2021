# Ice Cream Store REST Demo

This example build on the previous one but sepearates the two applications.

## Running the applications

To run the Vue application go into the `frontend` direction and run the command `npm run dev`.

To run the Spring Boot application go into the `backend` direction and run the command `mvn spring-boot:run`.

If you want to run both at the same time and are MacOS or Linux you can use the script `.start.sh` which runs both of the commands at once.

`npm run dev --prefix ./frontend & mvn spring-boot:run -f backend`
