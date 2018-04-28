Promise objects allow you to control the flow of deferred and asynchronous operations.

A Promise is in one of these states:

* pending: initial state, not fulfilled or rejected.
* fulfilled: successful operation
* rejected: failed operation.
* settled: the Promise is either fulfilled or rejected, but not pending.

**Loading an image with XHR**
A simple example using Promise and XMLHttpRequest to load an image is available at the MDN GitHub js-examples repository. You can also see it in action. Each step is commented and allows you to follow the Promise and XHR architecture closely. Here is the uncommented version, showing the Promise flow so that you can get an idea:

```
function imgLoad(url) {
  return new Promise(function(resolve, reject) {
    var request = new XMLHttpRequest();
    request.open('GET', url);
    request.responseType = 'blob';
    request.onload = function() {
      if (request.status === 200) {
        resolve(request.response);
      } else {
        reject(Error('Image didn\'t load successfully; error code:' 
                     + request.statusText));
      }
    };
    request.onerror = function() {
      reject(Error('There was a network error.'));
    };
    request.send();
  });
}
```