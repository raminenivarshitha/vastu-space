package com.vastudesign.backend.vastu;

import com.vastudesign.backend.entity.FurnitureItem;
import com.vastudesign.backend.entity.Room;
import com.vastudesign.backend.entity.RoomOpening;

import java.util.ArrayList;
import java.util.List;

public class LivingRoomVastuAnalyzer {

    public LivingRoomVastuReport analyze(
            Room room,
            List<FurnitureItem> furniture,
            List<RoomOpening> openings
    ) {

        List<VastuIssue> issues = new ArrayList<>();

        int score = 100;

        ZoneCalculator zoneCalculator = new ZoneCalculator();

        FurnitureItem sofa = furniture.stream()
                .filter(item -> "SOFA".equalsIgnoreCase(item.getType()))
                .findFirst()
                .orElse(null);

        FurnitureItem tv = furniture.stream()
                .filter(item -> "TV".equalsIgnoreCase(item.getType()))
                .findFirst()
                .orElse(null);

        RoomOpening door = openings.stream()
                .filter(opening -> "DOOR".equalsIgnoreCase(opening.getType()))
                .findFirst()
                .orElse(null);

        RoomOpening window = openings.stream()
                .filter(opening -> "WINDOW".equalsIgnoreCase(opening.getType()))
                .findFirst()
                .orElse(null);

        // SOFA RULE
        if (sofa == null) {

            score -= 15;

            issues.add(new VastuIssue(
                    "SOFA",
                    "WARNING",
                    "No sofa has been placed.",
                    "Place the main sofa toward the south, west, or southwest zone."
            ));

        } else {

            Direction sofaZone = zoneCalculator.calculateZone(
                    room.getWidth(),
                    room.getLength(),
                    sofa.getXPosition(),
                    sofa.getYPosition()
            );

            if (sofaZone == Direction.SOUTH_WEST
                    || sofaZone == Direction.SOUTH
                    || sofaZone == Direction.WEST) {

                issues.add(new VastuIssue(
                        "SOFA",
                        "GOOD",
                        "Sofa is placed in the " + sofaZone + " zone.",
                        "Current sofa placement is suitable."
                ));

            } else {

                score -= 15;

                issues.add(new VastuIssue(
                        "SOFA",
                        "WARNING",
                        "Sofa is placed in the " + sofaZone + " zone.",
                        "Consider moving the sofa toward south, west, or southwest."
                ));
            }
        }

        // TV RULE
        if (tv == null) {

            score -= 5;

            issues.add(new VastuIssue(
                    "TV",
                    "INFO",
                    "No TV has been placed.",
                    "If a TV is added, consider the southeast or east side."
            ));

        } else {

            Direction tvZone = zoneCalculator.calculateZone(
                    room.getWidth(),
                    room.getLength(),
                    tv.getXPosition(),
                    tv.getYPosition()
            );

            if (tvZone == Direction.SOUTH_EAST
                    || tvZone == Direction.EAST) {

                issues.add(new VastuIssue(
                        "TV",
                        "GOOD",
                        "TV is placed in the " + tvZone + " zone.",
                        "Current TV placement is suitable."
                ));

            } else {

                score -= 10;

                issues.add(new VastuIssue(
                        "TV",
                        "WARNING",
                        "TV is placed in the " + tvZone + " zone.",
                        "Consider moving the TV toward southeast or east."
                ));
            }
        }

        // DOOR RULE
        if (door == null) {

            score -= 15;

            issues.add(new VastuIssue(
                    "DOOR",
                    "WARNING",
                    "No entrance door has been added.",
                    "Add the room entrance so Vastu analysis can evaluate it."
            ));

        } else {

            String doorWall = door.getWall();

            if ("NORTH".equalsIgnoreCase(doorWall)
                    || "EAST".equalsIgnoreCase(doorWall)
                    || "NORTH_EAST".equalsIgnoreCase(doorWall)) {

                issues.add(new VastuIssue(
                        "DOOR",
                        "GOOD",
                        "Entrance is on the " + doorWall + " side.",
                        "Current entrance direction is suitable."
                ));

            } else {

                score -= 15;

                issues.add(new VastuIssue(
                        "DOOR",
                        "WARNING",
                        "Entrance is on the " + doorWall + " side.",
                        "North, east, or northeast entrances are preferred in this rule set."
                ));
            }
        }

        // WINDOW RULE
        if (window == null) {

            score -= 5;

            issues.add(new VastuIssue(
                    "WINDOW",
                    "INFO",
                    "No window has been added.",
                    "Add windows to improve room analysis."
            ));

        } else {

            String windowWall = window.getWall();

            if ("NORTH".equalsIgnoreCase(windowWall)
                    || "EAST".equalsIgnoreCase(windowWall)
                    || "NORTH_EAST".equalsIgnoreCase(windowWall)) {

                issues.add(new VastuIssue(
                        "WINDOW",
                        "GOOD",
                        "Window is on the " + windowWall + " side.",
                        "This placement supports the selected Vastu rules."
                ));

            } else {

                score -= 10;

                issues.add(new VastuIssue(
                        "WINDOW",
                        "WARNING",
                        "Window is on the " + windowWall + " side.",
                        "North or east-side windows are preferred in this rule set."
                ));
            }
        }

        if (score < 0) {
            score = 0;
        }

        String rating;

        if (score >= 90) {
            rating = "EXCELLENT";
        } else if (score >= 75) {
            rating = "GOOD";
        } else if (score >= 60) {
            rating = "NEEDS_IMPROVEMENT";
        } else {
            rating = "POOR";
        }

        return new LivingRoomVastuReport(
                score,
                rating,
                issues
        );
    }
}