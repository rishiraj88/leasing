# Leasing Application for All Mobility Groups

End-User Utility to take vehicles on lease, respect such leasing contracts and returning the lease vehicles to the providers. For use by customers (vehicle users)

## Preconditions to Run the Application

This application requires the following software packages to run properly:
- a command line interpreter. Bash is preferred. CMD for Windows also works. The command in this readme run very well with [Bash](https://www.gnu.org/software/bash/). For having Bash on a Windows box, you may install [Git Bash](https://git-scm.com/download/win).
- [Docker](https://www.docker.com/)
- a web browser. [Chrome](https://google.com/chrome/) is preferred. Other web browsers may work for most functionalities.

## Installation
- Clone the files (source and configuration files) from GitHub repository:
`git clone https://github.com/rishiraj88/leasing.git`

- Go to `leasing/contract` directory.

- Build the project:
`./gradlew build`

- Run this command in Bash (or another compatible shell) to build Docker image for the backend project:
`docker build -t i50729/contract .`

- Build the Docker container network by running:
`docker-compose build`
`docker-compose up -d`

- Go to `leasing\leasingclient` directory.

- Build and run the project with these commands:
`npm install`
`ng serve`

## How to Start the Application

- Now you may use the application by visiting this URL:
`http://localhost:4200/home`

- Freely navigate to and use the sections `Customers`, `Vehicles` and `Leasing Contracts` under `Manage` menu.

## Reason of Chosen Solution
The chosen solution corresponds to the use of some of the latest technologies available so as to model complex dynamic systems to work on heavy-cash businesses.

## Notes
Due to some constraints, I have built the MVP. For enhancing and fostering the solution, I am open to explain the relevant parameters and methods in the following tech discussion.

-- Rishi Raj
rishi.raj.88[at]gmail[dot]com
