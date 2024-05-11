# Leasingclient
This project is the web-based user interface (Web UI) for the project- vehicle leasing contract. It has been generated with [Angular CLI](https://github.com/angular/angular-cli) version 15.0.4.

## Development Server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload its updated state in case you have modified, replaced, added or removed any of its source files.

- Generic Instructions and Help from Angular Providers follows here. [TODO to be removed soon]
## Code Scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

## Guide to update your Angular application v16.0 -> v17.0 for basic applications
https://update.angular.io/?v=16.0-17.0

### Before you update
You don't need to do anything before moving between these versions.
Update to the new version

### During Update
Review these changes and perform the actions to update your application.
- Make sure that you are using a supported version of node.js before you upgrade your application. Angular v17 supports node.js versions: v18.13.0 and newer
- Make sure that you are using a supported version of TypeScript before you upgrade your application. Angular v17 supports TypeScript version 5.2 or later.
- Make sure that you are using a supported version of Zone.js before you upgrade your application. Angular v16 supports Zone.js version 0.14.x or later.
- In the application's project directory, run ng update @angular/core@17 @angular/cli@17 to update your application to Angular v17.
- Make sure you configure setupTestingRouter, canceledNavigationResolution, paramsInheritanceStrategy, titleStrategy, urlUpdateStrategy, urlHandlingStrategy, and malformedUriErrorHandler in provideRouter or RouterModule.forRoot since these properties are now not part of the Router's public API
- You may need to adjust the equality check for NgSwitch because now it defaults to stricter check with === instead of ==. Angular will log a warning message for the usages where you'd need to provide an adjustment.
- If you want the child routes of loadComponent routes to inherit data from their parent specify the paramsInheritanceStrategy to always, which in v17 is now set to emptyOnly.

### After you update
You don't need to do anything after moving between these versions.