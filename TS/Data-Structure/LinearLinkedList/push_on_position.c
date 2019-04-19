// function to create and return a Node
struct Node* getNode(int val) {

	// allocating space
	struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));

	// inserting the required data
	newNode -> data = val;
	newNode -> next = NULL;
	return newNode;
}

// function to insert a Node at required postion
int push_on_position (struct Node** head, int pos, int val) {

	// This condition to check whether the
	// postion given is valid or not.
	if (pos >= 1){

		// Keep looping until the pos is zero
		while (pos--) {

			if (pos == 0) {

				// adding Node at required postion
				struct Node* temp = getNode(val);

				// Making the new Node to point to
				// the old Node at the same position
				temp->next = *head;

				// Changing the pointer of the Node previous
				// to the old Node to point to the new Node
				*head = temp;
			}
			else {
				// Assign double pointer variable to point to the
				// pointer pointing to the address of next Node
				head = &(*head)->next;
				if (head == NULL){
					break;
				}
			}
		}
	}
}
