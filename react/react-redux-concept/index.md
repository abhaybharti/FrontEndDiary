##React
React is a library to writte client side JavaScript applications. It’s code re-usability, writing code in JSX and virtual DOM has made react popular and easy to work with.

##Redux
Redux is a library which controls the state of your JavaScript application. It provides a “unidirectional data flow” that helps to manage and organise data better and makes debugging a lot easier.

##Router
It’s an entry point of your application. There can be several routes in your application and you would need functionalities like validation, authentication, redirection, etc. depending upon the requirement. Handling them will come in the Redux part.

##SEPARATION OF CONCERNS
Separation of concerns (SoC) is a design principle for separating a computer program into distinct sections, such that each section addresses a separate concern.

##React/Representation part
###What it should do

    1. Render HTML content with the data provided.
    1. Have multiple UI states depending on the data, so that it’s clear to understand why it is shown.
    1. Dispatch actions on user interaction or life cycle events (conditional)
    1. Animation using ReactCSSTransitionGroup or any other libraries.
	
##What it shouldn’t do
React is a representation library. It should just give a view for the data provided to it and nothing more than it is intended to do.

    *Shouldn’t request for data, if it’s not present. It’s not a part of the representation. The Component should just display the UI, for the data is available. If the data is not present, show a default state or an error state depending upon the scenario.

	For example: Let’s take a TODO app; We have a React component which is supposed to show details of a TODO with ‘id’ 6. The component shouldn’t have a check, if the data is not available, dispatch an action to fetch the data.

	The best solution will be to fetch data from actions. The component will just take care of rendering HTML content based on data provided.
	
	**But the question here is: who will dispatch the actions if components don’t?**
	We know that entry point to your application is routes. When a route is matched, a component corresponding to that route is loaded and route handler for that route is called. So, the route handler will take care of dispatching that action.
	
	![Component shouldn’t dispatch action to request for data](https://cdn-images-1.medium.com/max/800/1*eNXzxmHkTt-ZxrZAkBfrJQ.jpeg)

	*Storing data in its local state (can be used if it’s an animation or a user input)
	
	You may store user inputs like text, number but it’s still best to keep it in redux store because you are never sure when the data of component could be used by some other component. And then you’ll have to keep pushing the data at top container components so that it can be shared with the lower ones. To avoid all this, store everything in the redux store.
	
	*Shouldn’t dispatch actions in a component’s life cycle events if action is not directly related to the life cycle event
	
	Life cycle events if not used properly can lead to so many issues which might not be easy to debug. Even if you are able to find the issue, you might have to do so many changes which might make your component even more complex and you might end up completely changing the structure. So, be very careful while using life cycle events.
	
	![Component shouldn’t dispatch action to request for data](https://cdn-images-1.medium.com/max/800/1*eNXzxmHkTt-ZxrZAkBfrJQ.jpeg)
	
	
	
	1. Fetch list details if not available: This is not correct because TODO LIST will not be a reusable component anymore as it will always be dependent on one type of data which it is trying to fetch. Also, we will have to add a condition to check if the data is available or not. It’s doing more than just a representation.
	   
    2. Start animation of header component: This is wrong because the event is related to a header. If the action has to be dispatched, it should be dispatched from header component’s life cycle.
    However, the best solution would be to dispatch the animation action from the entry point. It could be when the route is hit or any action is dispatched to show this UI which contains header component.
    3. Todo List viewed by user: This is the correct example. When the todo list is mounted, a user gets to see the list and that is what’s being updated through the action.
	
    4. Reset UI state on component unmount: This is a very good use of component life cycle. Suppose, you were viewing a particular TODO UI from a list. It has its own screen. You have few tabs for a TODO, like comments, notes, likes, etc. You always want the TODO to open with comments tab selected. So, on componentDidUnmount of the TODO, you will reset the tab selection to comments.
	
##Redux part

We discussed representation and user interaction till now, which will be a part of React. What about the other important things of our application?.

The answer is “Redux”.
It has 3 parts: **Actions**, **Reducers**, and **Store**.
I have clubbed the concerns into 2 groups:

1. Brain - This will use only Actions part of Redux
1. Storage - This will use Reducers and Store

**Brain**
So, the application data is maintained in redux store and representation in React. Everything else which will be a part of your application will come in the “brain”. It will decide how your application functions and what representation to be shown.

    **Everything which will be a part of a brain will be written in ACTIONS.**
	
Here are the concerns which will be a part of Brain. For each of these, there will be an entity which will take care of addressing that concern. For example: There will be a different class/file for handling routes like routeHandlers, and for validations routeValidator.

    *Business Logic
    This comprises of a model which has logic/algorithm for determining the state of our application. It can include simple algebraic operations to set of steps for performing a particular task.

    For example, let’s take a quiz app. On begin of a quiz, following things should happen: 

    1. show loading 
    2. fetch Quiz data 
    3. start Quiz timer 
    4. remove loading
    5. load questions

    This is the algorithm which will be followed to start to a quiz.
    Handling routes
	
    This will contain all the things which should happen after you hit any route.
	
    1. Check if the route is valid —For example: if someones hits a route /todo/18. We’ll have to validate if a TODO with id 18 exists or not. If not, then take necessary action
    2. Check if the user has permission to hit that route
    3. Reroute if required
    4. Check if enough data is available for that route, if not then fetch the data
	
    *API Calls
	
    All the AJAX requests will come here. This will comprise:
    1. An algorithm which should be followed by all AJAX requests.
    2. Error management or internet connectivity issues.
    3. Synchronizing or sending parallel multiple API calls.
    4. Grouping multiple APIs so that it can be reused.
	
    *Authorizations
	
    This comprises of all types of authentications which will be a part of your app:
    1. user authorization
    2. for seeing a particular UI
    3. for taking a particular action
    4. for hitting a particular route
    
	*Validations
    1. user input data
    2. data from AJAX requests
	
    *Controlling component’s state
    1. Component’s state can be changed/controlled based on the action
    2. Suppose we want to perform a heavy operation which might take few seconds of time. We should have a control to change the component’s state to ‘waiting’ so that it can show some loader in the UI till the operation is completed.
	
**Storage

    1. This will contain reducers(pure functions) and a single object called store which will save your application state
    2. The only way to change its state is by dispatching an action and it’ll update depending upon the action type and the data passed with the action
    3. The Store will trigger events when its state is updated.
    4. The view can subscribe to those events and update itself accordingly.
	
	[https://medium.com/prod-io/react-redux-architecture-part-1-separation-of-concerns-812da3b08b46]