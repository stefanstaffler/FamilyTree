package tree.family.graph;

import tree.family.controller.PersonController;
import tree.family.data.Person;
import tree.family.model.MainModel;
import tree.family.view.PersonView;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for the graph
 */
public class DrawGraph implements GraphInterface {
    /**
     * Method to create the buttons of every person.
     * Also calculates the position of the buttons.
     *
     * @param paneHeight: The height of the pane where the buttons are added.
     * @param model: Main model
     * @return the list with the buttons
     */
    @Override
    public List<PersonController> getPersonButtons(double paneHeight, MainModel model) {
        List<PersonController> personControllerList = new LinkedList<>();

        double middlePosition = paneHeight / 2;
        double distance = middlePosition;
        int distanceXDefault = 25;
        int distanceX = distanceXDefault;

        for (int layer = 0; layer <= 3; layer++) {
            int numberOfButtonsInLayer = (int) Math.pow(2, layer);

            if (numberOfButtonsInLayer == 1) {
                PersonView personView = new PersonView();
                PersonController personController = new PersonController(personView, model);

                Person person = new Person();
                person.setFirstName("New");
                person.setSurname("Person");
                personController.setData(person);

                personView.getRootPane().setLayoutX(distanceX);
                personView.getRootPane().setLayoutY(distance - personView.getRootPane().getPrefHeight() / 2);
                personControllerList.add(personController);
            } else {
                distance /= 2;

                PersonView pView = new PersonView();
                PersonController pController = new PersonController(pView, model);
                distanceX += pView.getRootPane().getPrefWidth() + distanceXDefault;

                for (int i = 0; i < numberOfButtonsInLayer / 2; i++) {
                    PersonView personView = new PersonView();
                    PersonController personController = new PersonController(personView, model);

                    Person person = new Person();
                    person.setFirstName("New");
                    person.setSurname("Person");
                    personController.setData(person);

                    personView.getRootPane().setLayoutX(distanceX);
                    personView.getRootPane().setLayoutY(
                            middlePosition - distance - personView.getRootPane().getPrefHeight() / 2
                                    - 2 * distance * i
                    );
                    personControllerList.add(personController);
                }
                for (int i = 0; i < numberOfButtonsInLayer / 2; i++) {
                    PersonView personView = new PersonView();
                    PersonController personController = new PersonController(personView, model);

                    Person person = new Person();
                    person.setFirstName("New");
                    person.setSurname("Person");
                    personController.setData(person);

                    personView.getRootPane().setLayoutX(distanceX);
                    personView.getRootPane().setLayoutY(
                            middlePosition + distance
                                    + 2 * distance * i
                    );
                    personControllerList.add(personController);
                }
            }
        }

        return personControllerList;
    }
}
