package com.careerdevs.fantasyfootball.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String lastName;
        private String firstName;
        private String position;
        private String proTeamName;
        private boolean isRostered;

        private short passingYards;
        private short passingTDs;
        private short interceptions;
        private short rushingYards;
        private short rushingTDs;
        private short receptions;
        private short receivingYards;
        private short receivingTDs;
        private short fumbles;

        public Player() {
        }

        public Player(Long id, String lastName, String firstName, String position, String proTeamName,
                      boolean isRostered, short passingYards, short passingTDs, short interceptions,
                      short rushingYards, short rushingTDs, short receptions, short receivingYards,
                      short receivingTDs, short fumbles) {
                this.id = id;
                this.lastName = lastName;
                this.firstName = firstName;
                this.position = position;
                this.proTeamName = proTeamName;
                this.isRostered = isRostered;
                this.passingYards = passingYards;
                this.passingTDs = passingTDs;
                this.interceptions = interceptions;
                this.rushingYards = rushingYards;
                this.rushingTDs = rushingTDs;
                this.receptions = receptions;
                this.receivingYards = receivingYards;
                this.receivingTDs = receivingTDs;
                this.fumbles = fumbles;
        }

        public Long getId() {
                return id;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getPosition() {
                return position;
        }

        public void setPosition(String position) {
                this.position = position;
        }

        public String getProTeamName() {
                return proTeamName;
        }

        public void setProTeamName(String proTeamName) {
                this.proTeamName = proTeamName;
        }

        public boolean isRostered() {
                return isRostered;
        }

        public void setRostered(boolean rostered) {
                isRostered = rostered;
        }

        public short getPassingYards() {
                return passingYards;
        }

        public void setPassingYards(short passingYards) {
                this.passingYards = passingYards;
        }

        public short getPassingTDs() {
                return passingTDs;
        }

        public void setPassingTDs(short passingTDs) {
                this.passingTDs = passingTDs;
        }

        public short getInterceptions() {
                return interceptions;
        }

        public void setInterceptions(short interceptions) {
                this.interceptions = interceptions;
        }

        public short getRushingYards() {
                return rushingYards;
        }

        public void setRushingYards(short rushingYards) {
                this.rushingYards = rushingYards;
        }

        public short getRushingTDs() {
                return rushingTDs;
        }

        public void setRushingTDs(short rushingTDs) {
                this.rushingTDs = rushingTDs;
        }

        public short getReceptions() {
                return receptions;
        }

        public void setReceptions(short receptions) {
                this.receptions = receptions;
        }

        public short getReceivingYards() {
                return receivingYards;
        }

        public void setReceivingYards(short receivingYards) {
                this.receivingYards = receivingYards;
        }

        public short getReceivingTDs() {
                return receivingTDs;
        }

        public void setReceivingTDs(short receivingTDs) {
                this.receivingTDs = receivingTDs;
        }

        public short getFumbles() {
                return fumbles;
        }

        public void setFumbles(short fumbles) {
                this.fumbles = fumbles;
        }
}
