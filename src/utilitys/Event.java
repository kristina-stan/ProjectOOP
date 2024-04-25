    package utilitys;

    public class Event {

        private Hall hall;
        private String name;
        private DateManager date;
        private AllSeats seats;
        //private int capacity;

        public Event(Hall hall, String name, DateManager date) throws Exception{

            this.hall = hall;
            setSeats(new AllSeats(hall.getSeats().getAllSeats())); // set seats
            setName(name); // event name
            //setCapacity(hall.getCapacity()); // total capasity
            setDate(date);
        }

        public void printEventSeats(){
            System.out.println("\"" + name + "\" on the "/*+ getFormattedDate()*/);
            seats.printAllSeats();
        }

        public void setName(String name) throws Exception{
            if(!name.matches("[a-zA-Z0-9 ':]+"))
                throw new Exception("Invalid event name!");
            this.name = name;
        }
        /*public void setCapacity(int capacity) {
            this.capacity = capacity;
        }*/
        public void setSeats(AllSeats seats) {
            this.seats = seats;
        }
        public void setDate(DateManager date) throws Exception {

            if(date.isValid())
                this.date = date; // Using DateManager for date parsing and validation
            else throw new Exception("You can add an event 4 years in advance!");

        }


        public String getName() {
            return name;
        }
        public int getHallNumber() {
            return hall.getNumber();
        }
        /*public int getCapacity() {
            return capacity;
        }*/
        public AllSeats getSeats() {
            return seats;
        }
        public Hall getHall(){
            return this.hall;
        }
        public DateManager getDate() {
            return this.date;
        }
       /* public String getFormattedDate() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return this.date.getDate().format(formatter);
        }*/

        public boolean isMatching(DateManager date) throws IllegalArgumentException {
            //DateManager parseDate = new DateManager(date);
            return this.date.getDate().isEqual(date.getDate());
        }
        public boolean isMatching(Hall hall){
            return this.hall == hall;
        }
        public boolean isMatching(String eventName){
            return this.name.equals(eventName);
        }
    }
