package org.example;

import java.time.LocalTime;
import java.util.Objects;


/**
 * Represents a client in a transportation problem scenario.
 * A client has a name, time constraints for service, and a type.
 */
public class Client {

    private  String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType type;

    /**
     * Constructs a new client with the given parameters.
     *
     * @param name the name of the client
     * @param minTime the minimum time the client can be serviced
     * @param maxTime the maximum time the client can be serviced
     * @param type the type of the client
     */
    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.type = type;

    }
    /**
     * Retrieves the name of the client.
     *
     * @return the name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the client.
     *
     * @param name the new name of the client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the minimum time the client can be serviced.
     *
     * @return the minimum time the client can be serviced
     */

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the client.
     *
     * @return a string representation of the client
     */
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", minTime=" + minTime +
                ", maxTime=" + maxTime +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

//pt tema: clasa problema: testez met equals
//