if ( ! com) var com = {}
if (!com.corejsf) {
  var focusLostTimeout
	com.corejsf = {   
	  errorHandler: function(data) { 
	    alert("Error occurred during Ajax call: " + data.description) 
	  },

	  updateCompletionItems: function(input, event) { 
		  var keystrokeTimeout

		  jsf.ajax.addOnError(com.corejsf.errorHandler)
		  
		  var ajaxRequest = function() {
		    
  			jsf.ajax.request(input, event, 
  		    { render: com.corejsf.getListboxId(input),
  		           x: Element.cumulativeOffset(input)[0],
  		           y: Element.cumulativeOffset(input)[1] + Element.getHeight(input)
  		    })
		  }
		  
		  window.clearTimeout(keystrokeTimeout)
		  keystrokeTimeout = window.setTimeout(ajaxRequest, 350)
    },

  	inputLostFocus: function(input) {  	  
  	  var hideListbox = function() {
  	    Element.hide(com.corejsf.getListboxId(input))
  	  }
  	 
  	  focusLostTimeout = window.setTimeout(hideListbox, 200)
  	},
  	
  	getListboxId: function(input) {
  	  var clientId = new String(input.name)
  	  var lastIndex = clientId.lastIndexOf(':')
  	  return clientId.substring(0, lastIndex) + ':listbox'
  	}
  }
}