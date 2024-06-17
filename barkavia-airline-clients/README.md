## Quick FAQ
> Why airline clients are represented in a single module, instead of having a module per airline? 
 
Simple, easy to maintain. Important details to know about airline clients – none of them will ever have a public official API, due to the nature of the business, meaning we'll need a custom client for each airline with shared core functionality.